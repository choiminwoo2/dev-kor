<script>
    import {createComment} from "../../server/comment.server.js";
    import {createEventDispatcher} from "svelte";

    let text = '';
    export let params = {};
    export let postId = 0;
    const dispatcher = createEventDispatcher();

    const handleInputText = (event) =>{
        text = event.target.value;
    }
    function addComment(comment){
        dispatcher('addCommentEvent', {comment: comment})
    }

    const handleSaveComment = (event) => {
        event.preventDefault();
        if(event.target !== event.currentTarget) {
            return;
        }
        const formObj = new FormData();
        formObj.append('text', text);
        formObj.append('writer', 'ㅇㅇ');
        formObj.append('postId', postId);

        const result = createComment(formObj);

        result.then((data) => {
            text = '';
            addComment(data);
        }).catch(error => {
            console.log(error);
        })
    }

</script>

<div class="flex flex-col h-48 border mb-10 mx-6 rounded mt-8">
    <form method="post" >
        <div class="border-b h-8 p-1 text-sm font-semibold">
            <span>ㅇㅇ</span>
        </div>
        <div class="relative h-40 p-2">
            <textarea bind:value={text} on:input={handleInputText} class="w-full outline-0 h-full bg-transparent"></textarea>
            <div class="absolute bottom-0 right-0 pr-8 pb-4">
                <button class="hover:text-blue-400" on:click={handleSaveComment}>작성하기</button>
            </div>
        </div>
    </form>
</div>