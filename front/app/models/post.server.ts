import useApi from "../../config/useApi";

type Post = {
    slug: string;
    title: string;
};

export async function getPosts(): Promise<Array<Post>> {
    return useApi.get("/board");
}