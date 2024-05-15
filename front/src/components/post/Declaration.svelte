<script>

import {faPencil} from "@fortawesome/free-solid-svg-icons";
import {faBell} from "@fortawesome/free-regular-svg-icons";
import Fa from "svelte-fa";
</script>

<div class="flex items-center justify-end min-h-12 h-12 border-b border-gray-600/70 align-baseline">
    <div class="whitespace-nowrap mr-2 md:flex justify-center items-center text-white">
        <a href="javascript:void(0)" class="flex h-9 bg-red-500 hover:bg-red-700 items-center rounded ">
            <Fa icon={faBell} class="pl-4"/>
            <button class="pr-4 pl">신고</button>
        </a>
    </div>
</div>