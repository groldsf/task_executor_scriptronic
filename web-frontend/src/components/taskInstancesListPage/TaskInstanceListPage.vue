<template>
  <div class="container">
    <h1>
      TaskInstances:
    </h1>
<!--    <task-card v-for="task in tasks" :key="task.id" :task-info="task"></task-card>-->
    <task-instance-card v-for="taskInstance in taskInstances" :key="taskInstance.id"
                        :task-instance-info="taskInstance"
    ></task-instance-card>

  </div>
</template>

<script>
import TaskInstanceCard from "@/components/taskInstancesListPage/TaskInstanceCard";
export default {
  name: "TaskInstanceListPage",
  components: {TaskInstanceCard},
  data(){
    return{
      taskInstances:[]
    }
  },
  async mounted() {
    try {
      const res = await this.$api.taskInstance.getTaskInstances()
      console.log(res.data)
      this.taskInstances = res.data
    } catch (error) {
      console.log(error)
    }
  }
}
</script>

<style scoped>

</style>