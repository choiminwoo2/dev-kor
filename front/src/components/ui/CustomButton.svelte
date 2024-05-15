<script>
    export let color = ''

    let bgColor = {
        'red': 'bg-red-400',
        'blue': 'bg-bgBlue-custom',
    }
</script>


<button class="h-9 {bgColor[color]} text-white py-2 px-4 rounded text-sm ">
    <slot></slot>
</button>


