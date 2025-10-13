import axios from "axios";
import type { Gif } from "../interfaces/gif.interface";

const api = axios.create({
    baseURL: "https://api.giphy.com/v1/gifs",
});

export const getGifsByQuery = async (query: string): Promise<Gif[]> => {
    const { data } = await api.get("/search", {
    params: {
        api_key: "PQxOFqchh0Ydx5ye6tSm9oj4d3PeeRc5",
        q: query,
        limit: 10,
        lang: "es",
    },
    });

    return data.data.map((gif: any) => ({
    id: gif.id,
    title: gif.title,
    url: gif.images.downsized_medium.url,
    }));
};
