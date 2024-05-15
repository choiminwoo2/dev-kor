<script>

    import Router, {params, location} from "svelte-spa-router";
    import {routes, routes_user} from "./route/index.js";
    import DefaultLayout from "./components/layout/DefaultLayout.svelte";
</script>

{#if $location != '/login'}
    <DefaultLayout>
        <Router {routes}/>
    </DefaultLayout>
{:else}
<Router routes={routes_user}></Router>
{/if}
<style>

</style>
