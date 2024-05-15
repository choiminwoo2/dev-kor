<script>
    import {createEventDispatcher} from 'svelte';
    import UpdateForm from "./UpdateForm.svelte";
    import Modal from "../ui/Modal.svelte";
    import {requestDeleteComment} from "../../server/comment.server.js";
    import {push} from "svelte-spa-router";

    export let commentList = []

    const dispatcher = createEventDispatcher();
    let text = '';
    $: isUpdated = false;
    $: showModal = false;
    $: itemId = 0;
    const deleteCommentItem = (commentId) => {
        dispatcher('deleteCommentHandler', {commentId: commentId});
    }
    const updateCommentItem = (comment) => {
        isUpdated = false;
        dispatcher('updatedCommentHandler', {comment: comment});
    }

    const deleteComment = (event) => {
        event.preventDefault();
        showModal = true;
        itemId = event.target.dataset.id;
    }

    const handleSuccessModal = (event) => {
        if (!event.detail.ok) {
            return;
        }
        showModal = false;
        const result = requestDeleteComment(itemId);

        result.then(data => {
            deleteCommentItem(data.data);
        }).catch(error => {
            push(`error/${error}`);
        })
    }

    const updateComment = (event) => {
        event.preventDefault();
        isUpdated = true;
        itemId = event.target.dataset.id;
        console.log(itemId);
        const preComment = event.target.dataset.text;
        text = preComment;
    }

    const receiveCommentData = (event) => {
        updateCommentItem(event.detail.comment);
    }

    const closeModal = (event) => {
        showModal = event.detail.showModal;
    }

</script>
{#if showModal}
    <Modal {showModal} on:success={handleSuccessModal} on:close={closeModal}/>
{/if}


<div class="comment-content-wrap w-full my-4">
    {#each commentList as item}
        <div class="comment-item h-32 overflow-y-auto hide-scrollbar mx-2 border rounded mt-4">
            <div class="h-full">
                <div class="flex justify-between border-b text-xs md:text-sm">
                    <span class="font-semibold px-2">ㅇㅇ</span>
                    <div class="flex gap-1 md:gap-4 px-2">
                        <button on:click={updateComment} data-text="{item.commentText}" data-id="{item.commentId}">수정
                        </button>
                        <button on:click={deleteComment} data-id="{item.commentId}">삭제</button>
                        <span>{item.updateAt}</span>
                        <a>신고</a>
                        <a>답글</a>
                    </div>
                </div>
                <div class="p-2 relative">
                    {item.commentText}
                </div>
            </div>
        </div>
        {#if isUpdated && item.commentId == itemId}
            <UpdateForm {text} commentId={item.commentId} on:updateCommentEvent={receiveCommentData}/>
        {/if}
    {/each}
</div>