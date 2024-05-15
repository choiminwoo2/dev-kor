<script>
    import {faPencil, faTrashCan} from "@fortawesome/free-solid-svg-icons";
    import { deletePost } from "../../server/post.server";
    import Fa from "svelte-fa";
    import { link } from "svelte-spa-router";
    import Modal from "../ui/Modal.svelte";

    export let postData = {
        id: 0,
        title: '',
        content: '',
        writer: '',
        updateAt: ''
    };
    export let boardUrl;
    let show = false;
    $: showModal = show;

    const deletePostHandler = (event) =>{
        showModal = event.detail.showModal;
        const isDelete = event.detail.ok;
        if(isDelete){
            deletePost(postData.id).then(data => {
                location.href = `#/b/${boardUrl}`;
            }).catch(error =>{
                location.href = `#/error`;
            })
        }
    }

    const handleDeleteBtn = (e) =>{
        e.preventDefault();
        showModal = true;
    }
    const closeModal = (event) =>{
        showModal = event.detail.showModal;
    }


</script>
{#if showModal}
    <Modal {showModal} on:success={deletePostHandler} on:close={closeModal}/>
    {:else}

{/if}

<div class="post-wrap flex flex-col">
    <div class="flex flex-row pb-3 items-center border-b border-gray-200 md:pb-0 md:items-start">
        <div class="overflow-hidden rounded-full bg-bgBlue-hover w-[55px] h-[55px] mx-2">
        </div>
        <header class="flex-grow h-full md:min-h-[80px] px-1">
            <header class="flex justify-between items-center">
                <span class="text-2xl font-medium">{postData.responseBoardDTO.name}</span>
                <div>
                    <button class="">구독</button>
                    <button>신고</button>
                </div>
            </header>
            <div class="hidden md:block text-sm">구독자 0000명 | 알림 수신 000명</div>
            <div class="hidden md:block text-sm">{postData.responseBoardDTO.description}</div>
        </header>
    </div>

    <div class="mt-4 md:mt-2">
        <div class="flex justify-end pr-2">
            <div class="flex text-base whitespace-nowrap justify-center items-center text-gray-800 hover:text-blue-400">
                <a href=""  use:link={{href:`/b/${boardUrl}/update/${postData.id}?url=${boardUrl}&title=${postData.title}&content=${postData.content}`}} class="flex h-9  items-center ">
                    <Fa icon={faPencil} class="pb-0.5 pl-2"/>

                    <button class="px-1">수정</button>
                </a>
            </div>
            <div class="flex text-base whitespace-nowrap justify-center items-center text-gray-900 hover:text-red-500 ">
                <a href="@" class="flex h-9  items-center ">
                    <Fa icon={faTrashCan} class="pb-0.5 pl-2"/>
                    <button class="px-1" on:click={handleDeleteBtn}>삭제</button>
                </a>
            </div>
        </div>
    </div>

    <div class="post-header flex h-12 justify-between items-center bg-gray-300/70 px-2 border-y border-gray-400/70 ">
        <h2 class="text-gray-900 text-2xl font-semibold ">{postData.title}</h2>
        <div class="whitespace-nowrap md:flex justify-center items-center text-white">
            <a href="javascript:void(0)" class="flex h-9 bg-bgBlue-custom hover:bg-bgBlue-hover items-center rounded ">
                <Fa icon={faPencil} class="pl-4"/>
                <button class="pr-4 pl-1">글쓰기</button>
            </a>
        </div>
    </div>
    <div class="post-sub-header px-2 py-1 min-h-6 border-b border-gray-400/70">
        <div class="block float-left h-4 w-full md:w-auto md:inline-block">
            <span>{postData.writer}</span>
        </div>
        <div class="float-right md:inline-block w-full md:w-auto sm:inline-block">
            <div class="float-right">
                <div class="flex justify-end gap-2 text-sm sm:inline-block">
                    <!-- 조회수와 추천 기능 훗날에 추가해야 합니다. -->
                    <span class=" font-semibold">조회수</span>
                    <span>11</span>
                    <span class="font-semibold">추천</span>
                    <span> 10</span>
                </div>
                <div class="sm:inline-block text-sm">
                    <span class="font-semibold">작성일</span>
                    <span>{postData.updateAt}</span>
                </div>
            </div>
        </div>
    </div>
    <div class="post_content py-1 px-2 pt-4 text-gray-900 min-h-80">
        <div><pre class="text-sm text-gray-900 font-pre">{postData.content}</pre></div>
    </div>
    <div class="flex justify-center gap-4 pb-4 border-b border-gray-400/70">
        <div class="flex text-base px-4 py-1 whitespace-nowrap border rounded border-gray-600/70 justify-center items-center text-gray-900/80 hover:text-blue-400 hover:border-blue-400">
            <a href="heaef" class="flex h-9  items-center ">
                <button class="px-1 font-semibold">추천!</button>
            </a>
        </div>
        <div class="flex text-base px-4 py-1 whitespace-nowrap border rounded border-gray-600/70 justify-center items-center text-gray-900/80 hover:text-blue-400 hover:border-blue-400">
            <a href="heaef" class="flex h-9  items-center ">
                <button class="px-1 font-semibold">비추!</button>
            </a>
        </div>
    </div>
</div>