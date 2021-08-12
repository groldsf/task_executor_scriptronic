<template>
  <div class="row">
    <div class="col-2">
      <h3>
        id: {{ taskInfo.id }}
      </h3>
    </div>

    <div class="col-2">
      <h3>
        name: {{ taskInfo.name }}
      </h3>
    </div>
    <div class="col"></div>
    <div class="col-1">
      <router-link :to="{name:'taskInfoPage', params:{ id: taskInfo.id}}">
        go
      </router-link>
    </div>

  </div>
</template>

<script>
export default {
  name: "TaskCard",
  props: {
    taskInfo: {
      id: Number,
      name: String
    }
  },
  data() {
    return {}
  }

}
</script>

<style scoped>

</style>