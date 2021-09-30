<template>
  <el-container>
    <el-header>
      <!--    头部-->
      <Header/>
    </el-header>
    <el-container style="height:100%">
      <el-aside width="210px" style="height:auto">
        <!--      侧边栏-->
        <Aside/>
      </el-aside >
      <el-container style="min-height:calc(100vh - 60px)">
        <el-main>
          <!--      内容-->
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </el-container>
</template>


<script>
import Header from "./components/Header";
import Aside from "./components/Aside";
import Footer from "./components/Footer";

export default {
  name: "Layout",
  components: {
    Header,
    Aside,
    Footer
  }
}
</script>


<style>
.el-header {
  position: relative;
  width: 100%;
  height: 60px;
}
.el-aside {
  display: block;
  position: absolute;
  left: 0;
  top: 60px;
  bottom: 0;
}
.el-main {
  position: absolute;
  left: 210px;
  right: 0;
  top: 60px;
  bottom: 0;
  overflow-y: scroll;
}

</style>