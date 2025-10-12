import GifList from "./gifs/components/GifList"
import { PreviousSearches } from "./gifs/components/PreviousSearches"
import { mockGifs } from "./mock-data/gifs.mock"
import { CustomHeader } from "./shared/components/CustomHeader"
import { SearchBar } from "./shared/components/SearchBar"

export const GifsApp = () => {
    return (
        <>
            {/* Header */}
            <CustomHeader 
                title="Buscador de gifs" 
                description = "Descubre y comparte el Gif perfecto"
            />

            {/* searchBar}*/}
            <SearchBar 
                buttonName= "Buscar gifs"
                placeHolder="Busca lo que quieras"
            />

            {/* PreviousSearches */}
            <PreviousSearches
                searches = {['goku', 'Dragon Ball Z']}
            />

            {/* Gifs */}
            <GifList gifs={mockGifs}/>

        </>
    )

}

