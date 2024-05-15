<script>
    import {link} from "svelte-spa-router";

    export let boardList = [{
        postId: 0,
        title: '',
        content: '',
        writer: '',
        commentCount: 0,
        updateAt: []
    }];
    export let queryString = ''

    export let boardUrl = ''

    console.dir(boardList);

    let max = boardList.length;

</script>
<div class="mt-5 w-full">
    <div class="item-header hidden md:flex border-b border-gray-200 w-full items-center h-14 md:h-9 px-1.5 py-2 ">
        <div class="item-inner flex flex-col flex-1 md:flex-row justify-center">
            <div class="item-top flex flex-1 items-center">
                <span class="hidden w-auto md:inline md:w-12 md:text-center mr-4">번호</span>
                <span class="text-sm font-semibold text-gray-800">제목</span>
            </div>
            <div class="item-bottom flex justify-between items-center">
                <div class="flex gap-4">
                    <span class="text-sm md:min-w-20 text-gray-800 mr-16 pl-1">작성자</span>
                    <span class="text-sm md:min-w-20 text-gray-800 mr-4">작성일</span>
                    <span class="text-sm md:min-w-24  text-gray-800 ">조회수</span>
                    <span class="text-sm md:min-w-12 text-gray-800 ">추천</span>
                </div>
            </div>
        </div>
    </div>
    {#each boardList as boardItem, idx}
        <a href="/" use:link={{href: `/b/${boardUrl}/post/${boardItem.postId}?${queryString}` }} alt="test"
           class="item flex border-b border-gray-200 w-full items-center h-14 md:h-9 px-1.5 py-2 ">
            <div class="item-inner flex flex-col flex-1 md:flex-row justify-center">
                <div class="item-top flex flex-1 items-center">
                    <span class="hidden w-auto md:inline text-sm md:w-12 md:text-center md:text-gray-800 mr-4">{max  - idx}</span>
                    <span class="text-sm font-semibold text-gray-800">{boardItem.title}
                        {#if boardItem.commentCount > 0}
                        <sub>[{boardItem.commentCount}]</sub>
                        {/if}
                    </span>
                </div>
                <div class="item-bottom flex justify-between items-center py-1 md:py-0">
                    <span class="text-xs text-gray-500 md:min-w-20 md:text-gray-800 md:text-sm mr-20 whitespace-nowrap text-center">{boardItem.writer}</span>
                    <div class="flex gap-4 items-center">
                        <span class="text-xs text-gray-500 md:min-w-20 md:text-sm md:text-gray-800">{boardItem.updatedAt}</span>
                        <span class="text-xs text-gray-500 text-center md:min-w-24 md:text-sm md:text-gray-800 whitespace-nowrap">조회 1</span>
                        <span class="text-xs text-gray-500 text-center md:min-w-20 md:text-sm md:text-gray-800 whitespace-nowrap">추천 0</span>
                    </div>
                </div>
            </div>
        </a>
    {:else}
        <li> Not Found Data</li>
    {/each}
</div>