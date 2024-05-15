<script>
    import {link, push} from "svelte-spa-router";
    import {faPencil, faSearch, faBars} from "@fortawesome/free-solid-svg-icons";
    import Fa from "svelte-fa";
    import BoardList from "./BoardList.svelte";



    export let boardData;

    console.dir(boardData);
    if(boardData === ''){
        push('/error');
    }
    let urlSearchParams = new URLSearchParams({

        "boardUrl": boardData.boardUrl
    });

    let queryString = urlSearchParams.toString();

</script>

<div class="flex flex-col ">
    <div class="flex flex-row">
        <div class="overflow-hidden rounded-full bg-bgBlue-hover w-[30px] h-[30px] md:w-[55px] md:h-[55px] mx-2">
        </div>
        <header class="flex-grow h-full md:min-h-[80px] px-1">
            <header class="flex justify-between items-center">
                <span class="text-2xl font-medium">{boardData.boardName}</span>
                <div>
                    <button class="">구독</button>
                    <button>신고</button>
                </div>
            </header>
            <div class="hidden md:block text-sm">구독자 0000명 | 알림 수신 000명</div>
            <div class="hidden md:block text-sm">{boardData.boardDescription}</div>
        </header>
    </div>
    <div class="flex flex-col py-5 md:flex-row border-b border-gray-200 px-1">
        <div class="hidden whitespace-nowrap md:flex mx-2 justify-center items-center text-white">
            <a href="@" use:link={{href:`/b/${boardData.boardUrl}/add?url=${boardData.boardUrl}`}} class="flex h-9 bg-bgBlue-custom hover:bg-bgBlue-hover items-center rounded ">
                <Fa icon={faPencil} class="pb-0.5 pl-2"/>
                <button class="px-2">작성하기</button>
            </a>
        </div>
        <div class="relative overflow-x-auto hide-scrollbar md:flex-grow whitespace-nowrap text-xs md:text-sm flex sm:justify-center flex-row items-center gap-x-8">
            <!--TODO: Board 카테고리 만들고 진행해야합니다. -->
            <a href="" class="text-blue-400 hover:text-blue-400">전체</a>
            <a href="" class="hover:text-blue-400">카테고리1</a>
            <a href="" class="hover:text-blue-400">카테고리1</a>
            <a href="" class="hover:text-blue-400">카테고리1</a>
            <a href="" class="hover:text-blue-400">카테고리2</a>
            <a href="" class="hover:text-blue-400">카테고리3</a>
            <a href="" class="hover:text-blue-400">카테고리3</a>
        </div>
        <div class="flex order-1 h-full pt-4 justify-between md:pt-0 md:justify-normal items-center gap-2">
            <div class="flex-grow justify-center items-center min-h-10 min-w-5 px-5 py-1 border rounded-3xl md:hidden">
                <input type="text" placeholder="검색"
                       class="overflow-hidden w-full outline-0 pt-0.5"/>
            </div>
            <div class="flex min-h-10 gap-2">
                <div class="flex md:hidden">
                    <button class="flex items-center border rounded text-gray-700/80 border-gray-700/20  hover:border-gray-700/50 hover:text-gray-900 px-2">
                        <Fa icon={faSearch} class="px-2"/>
                    </button>
                </div>
                <div class="flex ">
                    <button class="flex whitespace-nowrap items-center border rounded text-gray-700/80 border-gray-700/20  hover:border-gray-700/50 hover:text-gray-900 px-2">
                        <Fa icon={faBars} class="px-2"/>
                        <!-- TODO: 페이지 네이션 및 최신순 관련 업데이트가 필요합니다. -->
                        <span class="hidden md:inline">최신순</span></button>
                </div>
            </div>
        </div>
    </div>
    <BoardList boardList={boardData.list} boardUrl={boardData.boardUrl} {queryString}/>
</div>