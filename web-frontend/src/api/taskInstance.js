export default function (instance){
    return {
        getTaskInstances(){
            return instance.get('taskInstances/')
        },
        getTaskInstancesByTaskId(id){
            return instance.get('task/'+ id +'/taskInstances')
        },
        getTaskInstance(id){
            return instance.get('taskInstances/' + id)
        }
    }
}