<template>
  <div class="row">
    <h3 class="col-2">
      id: {{ taskInstance.id }}
    </h3>
    <h3 class="col-2">
      task_id: {{ taskInstance.task_id }}
    </h3>
  </div>
</template>

<script>
export default {
  name: "TaskInstanceInfoPage",
  data() {
    return {
      id: this.$route.params.id,
      taskInstance:{}
    }
  },
  async mounted() {
    try {
      const res = await this.$api.taskInstance.getTaskInstance(this.id)
      console.log(res.data)
      this.taskInstance = res.data
    } catch (error) {
      console.log(error)
    }
  }
}
</script>

<style scoped>

</style>