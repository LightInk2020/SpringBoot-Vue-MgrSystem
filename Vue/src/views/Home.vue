<template>
  <div style="margin: 20px 0">
    <div style="margin: 10px 10px">
      <!--    搜索区-->
      <el-input v-model="search" placeholder="请输入搜索内容" style="width: 25%" clearable/>
      <el-button style="margin-left:5px" @click="load">搜索</el-button>
      <!--      添加-->
      <el-button style="float:right" type="primary" @click="add">添加</el-button>
    </div>
    <div style="margin: 10px 10px">
      <el-table :data="tableData" border stripe>
        <el-table-column prop="id" width="180px" label="ID" sortable/>
        <el-table-column prop="username" label="用户名"/>
        <!--      注意后台的_下划线会转换为头峰即（大写首字母）-->
        <el-table-column prop="nickName" label="昵称"/>
        <el-table-column prop="age" label="年龄"/>
        <el-table-column prop="sex" label="性别"/>
        <el-table-column prop="address" label="地址"/>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.row)"
            >编辑
            </el-button>
            <el-popconfirm
                title="您确定删除吗?"
                @confirm="handleDelete(scope.row.id)"
            >
              <template #reference>
                <el-button
                    size="mini"
                    type="danger"
                >删除
                </el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <div class="demo-pagination-block">
        <el-pagination
            v-model:currentPage="currentPage"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        >
        </el-pagination>
      </div>
      <!--      添加/编辑窗口-->
      <el-dialog
          v-model="dialogVisible"
          :title="dialogTitle"
          width="40%"
      >
        <el-form ref="form" :model="form" label-width="20%">
          <el-form-item label="用户名">
            <el-input v-model="form.username" style="width: 80%" clearable></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickName" style="width: 80%" clearable></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input-number v-model="form.age" :min="1" :max="150"/>
          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.address" style="width: 80%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save"
        >确定</el-button
        >
      </span>
        </template>
      </el-dialog>
    </div>
  </div>

</template>

<script>

import request from "../utils/request";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      form: {},
      dialogTitle: '添加窗口',
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 10,
      tableData: [],
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get("http://localhost:9090/user", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    add() {
      this.dialogTitle = "添加窗口"
      this.form = {}
      this.form.age=1
      this.dialogVisible = true
      //表单其实是一直存在的  只不过dialogVisible控制其显示或隐藏
    },
    save() {
      if (this.form.id) { //更新
        request.put("http://localhost:9090/user", this.form).then(res => {
          console.log(res)
          console.log(res.code)
          if (res.code === "0") {
            this.$messageBox({
              type: "success",
              message: "修改成功！"
            })
          } else {
            this.$messageBox({
              type: "error",
              message: "修改失败！"
            })
          }
        })
        this.load()
      } else { //增加
        request.post("http://localhost:9090/user", this.form).then(res => {
          console.log(res)
          console.log(res.code)
          if (res.code === "0") {
            this.$messageBox({
              type: "success",
              message: "添加成功！"
            })
          } else {
            this.$messageBox({
              type: "error",
              message: "添加失败！"
            })
          }
        })
      }
      this.load()
      this.form = {}
      this.dialogVisible = false
    },
    handleEdit(row) {
      this.dialogTitle = "编辑窗口"
      //避免浅拷贝  即点击取消后还是把原来的数据替换掉了
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(id) {
      console.log(id)
      request.delete("http://localhost:9090/user/"+id).then(res =>{
        if (res.code === "0") {
          this.$messageBox({
            type: "success",
            message: "删除成功！"
          })
        } else {
          this.$messageBox({
            type: "error",
            message: "删除失败！"
          })
        }
        this.load()
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      this.load()
    }
  }
}
</script>

<style>
.demo-pagination-block {
  margin-top: 10px;
}
</style>