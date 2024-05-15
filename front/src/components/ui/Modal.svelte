<script>
    import {createEventDispatcher} from "svelte";

    export let showModal = true;
    const dispatcher = createEventDispatcher();

    function successfulRequest(){
        dispatcher('success', {showModal: false, ok : true})
    }
    function onCloseModal(){
        dispatcher('close', {showModal: false, ok : false})
    }

</script>
{#if showModal}
    <div class="backdrop" on:click={onCloseModal}>
        <div class="modal">
            <p>삭제하시면 데이터가 영구 삭제됩니다.</p>
            <button on:click={successfulRequest} class="bg-red-400 border rounded px-8 py-1">예</button>
            <button on:click={onCloseModal} class=" border rounded px-4 py-1">아니오</button>
        </div>
    </div>
{/if}
<style>  .backdrop {
    width: 100%;
    height: 100%;
    position: fixed;
    top: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.8);
}

.modal {
    padding: 10px;
    border-radius: 10px;
    max-width: 400px;
    margin: 10% auto;
    text-align: center;
    background: white;
}

</style>
