<script>
    import {getBoard} from '../server/board.server.js'
    import SideItem from "../components/board/SideItem.svelte";
    import BoardContent from "../components/board/BoardContent.svelte";
    import LoadingSpinner from "../components/ui/LoadingSpinner.svelte";

    export let params = {};
    $: boardUrl = params.boardUrl;

    $: {
        console.log(boardUrl);
    }
    $: items = getBoard(boardUrl);



</script>
<SideItem/>
<div class="col-span-8 md:col-span-8 lg:col-span-6 overflow-x-auto max-w-full w-full">
    {#await items}
      <LoadingSpinner />
    {:then data}
        <BoardContent boardData={data}/>
    {:catch error}
        <p>{error}</p>
    {/await}
</div>
<SideItem/>