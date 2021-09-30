<template>
  <!--  flex布局相当于将块状布局作为行内元素使用-->
  <div style="height: 60px; line-height: 60px; border-bottom: 1px solid #DCDFE6;display: flex;">
    <div style="width: 200px;padding-left: 30px; font-weight: bold; color: #409EFF; font-size: 20px;">后台管理</div>
    <div style="flex: 1">
      <!--头部菜单栏-->
    </div>
    <div style="width: 100px">
      <el-dropdown>
        <span class="el-dropdown-link">
          Dropdown<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>Action 1</el-dropdown-item>
            <el-dropdown-item>Action 2</el-dropdown-item>
            <el-dropdown-item divided>Action 3</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
}

.el-dropdown-link:hover {
  color: #409eff;
}

.el-icon-arrow-down {
  font-size: 12px;
}
</style>