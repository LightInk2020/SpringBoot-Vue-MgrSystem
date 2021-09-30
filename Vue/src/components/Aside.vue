<template>
<!--  <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">-->
<!--    <el-radio-button :label="false">expand</el-radio-button>-->
<!--    <el-radio-button :label="true">collapse</el-radio-button>-->
<!--  </el-radio-group>-->
  <div style="height: 100%">
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @open="handleOpen"
        @close="handleClose"
    >
      <el-sub-menu index="1">
        <template #title>
          <i class="el-icon-location"></i>
          <span>Navigator One</span>
        </template>
        <el-sub-menu index="1-1">
          <template #title><span>item one</span></template>
          <el-menu-item index="1-1-1">item one</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-2">item two</el-menu-item>
        <el-menu-item index="1-3">item three</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <template #title>Navigator Two</template>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-document"></i>
        <template #title>Navigator Three</template>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <template #title>Navigator Four</template>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}

</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 210px;
  /*注意calc(100vh空格-空格60px)  不加空格会报错*/
  /*min-height:calc(100vh - 60px);*/
  height:100%;
}
</style>