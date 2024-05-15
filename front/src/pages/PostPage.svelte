<script>
    import {querystring} from "svelte-spa-router";
    import {parse} from 'qs'
    import {getPost} from "../server/post.server.js";
    import PostContent from "../components/post/PostContent.svelte";
    import Comment from "../components/comment/Comment.svelte";
    import SideItem from "../components/board/SideItem.svelte";
    import LoadingSpinner from "../components/ui/LoadingSpinner.svelte";
    import Declaration from "../components/post/Declaration.svelte";

    export let params = {}

    $: boardUrl = parse($querystring)['boardUrl'];
    $: postAndCommentData = getPost(params.postId, boardUrl);
    $: {
        console.log(postAndCommentData);
    }

</script>

<div class="col-span-8 md:col-span-6 ml-0 md:ml-2">
    {#await postAndCommentData}
        <LoadingSpinner/>
    {:then data}
        <PostContent {boardUrl} postData={data}/>
        <Declaration/>
        <Comment postId={data.id} commentData={data.comments}/>
    {:catch error}
        <p>{error}</p>/
    {/await}
</div>
<div class="hidden md:block col-start-7 col-end-9">
    <SideItem/>
</div>