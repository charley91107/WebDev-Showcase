import type { GiphyRandomResponse } from "./data/giphy.response";



const API_KEY = 'PQxOFqchh0Ydx5ye6tSm9oj4d3PeeRc5'


const myRequest = fetch(
    `https://api.giphy.com/v1/gifs/random?api_key=${ API_KEY }&tag=&rating=g`
);


const createImageInsideDom = ( url: string ) => {
    const imgElement = document.createElement('img');
    imgElement.src = url;
    document.body.append(imgElement);
}

myRequest
    .then( ( response ) => response.json())
    .then(({ data }: GiphyRandomResponse) => {
        const imageUrl = data.images.original.url;
        createImageInsideDom(imageUrl);
        
    })
    .catch( (error) => {
        console.error(error)
    })