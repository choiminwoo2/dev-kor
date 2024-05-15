<script>
    import {link} from "svelte-spa-router";
    import {faUser} from "@fortawesome/free-solid-svg-icons";
    import Fa from "svelte-fa";
</script>

<header class="flex flex-row h-12 min-h-12 justify-center border-b border-gray-900/60">
    <div class="flex max-w-[1280px] flex-grow h-full">
        <div class="flex items-center w-full">
            <h2 class="inline-block">
                <a href="/" class="text-3xl font-bold">DevKor</a>
             </h2>
            <div class="flex-grow">
                <div class="flex items-center font-medium text-base pl-[50px] md:pl-[120px] gap-6 ">
                    <a use:link={{href: "/b/community"}} class="hover:text-blue-400">커뮤니티</a>
                    <a use:link={{href: "/b/qna"}} class="hover:text-blue-400">Q&A</a>
                </div>
            </div>
            <div class="">
                <Fa icon={faUser} class="mx-2 hover:text-blue-400"/>
            </div>
        </div>
    </div>
</header>