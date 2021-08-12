<template>
  <div class="row">
    <h3 class="col-2">
      id: {{ taskInstanceInfo.id }}
    </h3>
    <h3 class="col-2">
      task_id: {{ taskInstanceInfo.task_id }}
    </h3>
    <router-link :to="{name:'taskInstanceInfoPage', params:{ id: taskInstanceInfo.id}}" class="col">
      go
    </router-link>
  </div>
</template>

<script>
export default {
  name: "TaskInstanceCard",
  props: {
    taskInstanceInfo: {
      id: Number,
      task_id: Number
    }
  },
  data() {
    return {}
  },
  async mounted() {
    console.log(this.taskInstanceInfo)
  }
}
</script>

<style scoped>

</style>