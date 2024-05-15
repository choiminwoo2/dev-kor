<script>
    import {createComment} from "../../server/comment.server.js";
    import {createEventDispatcher, onMount} from "svelte";
    import {updateComment} from "../../server/comment.server.js";
    export let text = '';
    export let commentId = 0;
    let inputBind;
    const dispatcher = createEventDispatcher();

    const handleInputText = (event) =>{
        text = event.target.value;
    }
    function dispatcherUpdateComment(comment){
        dispatcher('updateCommentEvent', {comment: comment})
    }

    const handleUpdateComment = (event) => {
        event.preventDefault();
        if(event.target !== event.currentTarget) {
            return;
        }
        const formObj = new FormData();
        formObj.append('text', text);
        formObj.append('commentId', commentId);

        const result = updateComment(formObj);

        result.then((data) => {
            dispatcherUpdateComment(data);
            text = '';
        }).catch(error => {
            console.log(error);
        })
    }
    onMount(() =>{
        inputBind.focus();
    })
</script>

<div class="flex flex-col h-48 border mb-10 mx-6 rounded mt-8">
    <form method="post" >
        <div class="border-b h-8 p-1 text-sm font-semibold">
            <span>ㅇㅇ</span>
        </div>
        <div class="relative h-40 p-2">
            <textarea bind:value={text} on:input={handleInputText} bind:this={inputBind} class="w-full outline-0 h-full bg-transparent"></textarea>
            <div class="absolute bottom-0 right-0 pr-8 pb-4">
                <button class="hover:text-blue-400" on:click={handleUpdateComment}>수정</button>
            </div>
        </div>
    </form>
</div>