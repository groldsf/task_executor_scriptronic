<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Icon))</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link :to="{name:'taskListPage'}" class="nav-link">
              tasks
            </router-link>
          </li>
          <li class="nav-item">
            <router-link :to="{name:'taskInstanceListPage'}" class="nav-link">
              taskInstances
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>



</template>

<script>
export default {
  name: "MenuHeader"
}
</script>

<style scoped>
.row {
  background-color: darkgray;
}
</style>