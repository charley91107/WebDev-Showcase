import GifList from "./gifs/components/GifList";
import { PreviousSearches } from "./gifs/components/PreviousSearches";
import { useGifs } from "./gifs/hooks/useGifs";
import { CustomHeader } from "./shared/components/CustomHeader";
import { SearchBar } from "./shared/components/SearchBar";

export const GifsApp = () => {

    const {
        gifs,
        previousTerms,
        handleTermClicked,
        handleSearch 
    } = useGifs();

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

