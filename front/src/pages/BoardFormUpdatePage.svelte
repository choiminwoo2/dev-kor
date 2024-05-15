<script>
    import CustomButton from "../components/ui/CustomButton.svelte";
    import {push, querystring} from "svelte-spa-router";
    import {createPost, updatePost} from "../server/post.server.js";
    import {parse} from "qs";

    export let params = {}
    let title = parse($querystring)['title'];
    let content = parse($querystring)['content'];

    const handleTitleInput = (event) => {
        title = event.target.value;
    }

    const handleContentInput = (event) => {
        content = event.target.value;
    }

    const updateForm = async (e) => {
        e.preventDefault();
        if (e.target !== e.currentTarget) {
            return;
        }
        //컨트롤러에서 유저가 작업한 것을 몽고 DB를 사용해보자..
        const formObj = new FormData();
        formObj.append('title', title);
        formObj.append('content', content);
        updatePost(params.postId, formObj).then(data => {
            push( `#/b/${params.boardUrl}/post/${params.postId}?boardUrl=${params.boardUrl}`);
        }).catch(error => {
            console.log(error);
        });
    };
</script>


<div class=" col-span-7 min-h-96 w-full ">
    <div class="mt-10">
        <h1 class="text-2xl font-semibold">게시글 수정</h1>
        <span class="font-medium">글을 수정하고 사람들과 의견을 나눕니다.</span>
    </div>
    <form action="" method="post" class="flex flex-col gap-4 mt-4">
        <div>
            <CustomButton color={'blue'}><a on:click={updateForm}>수정</a></CustomButton>
        </div>
        <!--TODO: 카테고리 추가 해야할 영역 -->
        <div class="hidden border h-9 rounded">

        </div>
        <div class="flex items-center border h-9 rounded">
            <input type="text" name="title" bind:value={title} on:input={handleTitleInput}
                   class="px-4 w-full outline-0"
                   placeholder="제목을 작성해주세요." required/>
        </div>
        <div class="min-h-96 max-h-[26.5rem] border rounded">
            <div class="border-b h-8"></div>
            <textarea name="content" bind:value={content} on:input={handleContentInput}
                      class="m-0 h-96 w-full outline-0 p-4 overflow-y-scroll hide-scrollbar"
                      placeholder="내용을 입력해주세요." required></textarea>
        </div>
    </form>
</div>