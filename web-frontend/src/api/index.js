import instance from "@/api/instance";
import taskModule from "@/api/task";
import taskInstanceModule from "@/api/taskInstance";

export default {
    task: taskModule(instance),
    taskInstance: taskInstanceModule(instance)
}
