<script>
    import Header from "./Header.svelte";
</script>
<div class="h-screen w-screen flex flex-col font-pre">
    <Header/>
    <div class="flex flex-col w-full mx-auto pt-[36px]">
    <div class="flex-grow">
        <div class="grid grid-cols-8 md:grid-cols-8  gap-4 min-h-72 mx-auto max-w-[1280px]">
    <slot></slot>
        </div>
    </div>
    </div>
</div>