<script>
    import CommentList from "./CommentList.svelte";
    import CommentForm from "./CommentForm.svelte";

    export let commentData = [];
    export let postId = 0;
    let isUpdated = true;

    const addComment = (event) => {
        commentData = [...commentData, event.detail.comment]
    }

    const updatedOnComment = (event) => {
        const updatedComment = event.detail.comment;
        console.log("세번째 동작");
        console.log("updatedComment", updatedComment);
        commentData = commentData.map(comment => {
            if(comment.commentId == updatedComment.commentId){
                return comment = updatedComment;
            }
            return comment;
        })
        isUpdated= false;
    }

    const deleteOnComment = (event) => {
        const removeId = event.detail.commentId;
        commentData = commentData.filter(comment => comment.commentId !== removeId);
    }

</script>

<div class="comment-wrap">
    <header class="flex items-center border-b border-gray-400/70">
        <span class="text-2xl font-semibold py-2 md:py-4 pl-1">댓글</span>
    </header>
    <div>
        {#if commentData.length > 0}
            <CommentList commentList={commentData} on:updatedCommentHandler={updatedOnComment} on:deleteCommentHandler={deleteOnComment}/>
        {/if}
        <CommentForm {postId} on:addCommentEvent={addComment}/>
    </div>
</div>