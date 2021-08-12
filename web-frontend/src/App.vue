<template>
  <div id="app" class="container">
    <menu-header></menu-header>
    <router-view/>
  </div>
</template>

<script>

import MenuHeader from "@/components/menu_header/MenuHeader";
export default {
  name: 'App',
  components: {MenuHeader},
  created() {
    // this.$store.dispatch('loadTasks')
  }
}
</script>

<style>
body{
  margin: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  /*margin-top: 60px;*/

}
</style>
