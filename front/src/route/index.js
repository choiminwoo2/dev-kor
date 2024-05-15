import Home from '../pages/Home.svelte'
import Board from '../pages/BoardPage.svelte'
import BoardFormPage from '../pages/BoardFormPage.svelte'
import Post from '../pages/PostPage.svelte'
import NotFound from "../pages/NotFound.svelte";
import SignPages from "../pages/SignPages.svelte";
import BoardFormUpdatePage from "../pages/BoardFormUpdatePage.svelte";
export const routes = {
    // Exact path
    '/': Home,

    // Using named parameters, with last being optional
    '/b/:boardUrl': Board,

    '/b/:boardUrl/add': BoardFormPage,

    '/b/:boardUrl/update/:postId' : BoardFormUpdatePage,

    // Wildcard parameter
    '/b/:boardName/post/:postId': Post,

    '/error': NotFound,
    // Catch-all
    // This is optional, but if present it must be the last
    '*': NotFound,
}

export const routes_user = {
    '/login' : SignPages,
}

