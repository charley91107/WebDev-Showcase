import { useState } from "react"
import { getGifsByQuery } from "./gifs/actions/get-gifs-by-query.action"
import GifList from "./gifs/components/GifList"
import { PreviousSearches } from "./gifs/components/PreviousSearches"
import { CustomHeader } from "./shared/components/CustomHeader"
import { SearchBar } from "./shared/components/SearchBar"
import type { Gif } from "./gifs/interfaces/gif.interface"



export const GifsApp = () => {

    const [gifs, setGifs] = useState<Gif[]>([]);
    const [previousTerms, setPreviousTerms] =  useState<string[]>([]);

    const handleTermClicked = ( term: string ) => {
        console.log({term});
    }

    const handleSearch = async (query: string = '') => {
        const term = query.trim().toLowerCase();
        if(!query){
            return;
        }

        if (previousTerms.includes(term)){
            return;
        };
        
        setPreviousTerms((serie) => {
            const update = [term, ...serie];
            return update.slice(0, 8);
        });

        const gifs = await getGifsByQuery(query);

        setGifs(gifs);

    }

    return (
        <>
            {/* Header */}
            <CustomHeader 
                title="Buscador de gifs" 
                description = "Descubre y comparte el Gif perfecto"
            />

            {/* searchBar}*/}
            <SearchBar 
                placeHolder="Busca lo que quieras"
                onQuery= {handleSearch}
            />

            {/* PreviousSearches */}
            <PreviousSearches searches = {previousTerms} onLabelClicked={handleTermClicked}
            />

            {/* Gifs */}
            <GifList gifs={gifs}/>

        </>
    )

}

