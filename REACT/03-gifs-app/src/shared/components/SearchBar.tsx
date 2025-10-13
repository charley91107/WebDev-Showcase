import { useEffect, useState, type KeyboardEvent } from "react";

interface Props {
    placeHolder?: string;

    onQuery: (query:string) => void;
}

export const SearchBar = ({ placeHolder='Buscar', onQuery}: Props) => {

    const [query, setQuery] = useState('');

    useEffect(() => {
        const timeoutId = setTimeout(() => {
            onQuery(query)
        }, 700)

        //onQuery(query);

        return () => {
            clearTimeout(timeoutId);
        }
    }, [query, onQuery])

    const handleSeartch = () => {
        onQuery(query);
    };

    const handleKeyDown = (event: KeyboardEvent<HTMLInputElement>) => {
        if(event.key === 'Enter'){
            handleSeartch();
        }
    }

    return(
        <div className="search-container">
            <input 
                type="text" 
                placeholder={ placeHolder }
                value={query}
                onChange={ (event)=> setQuery(event.target.value)}
                onKeyDown={handleKeyDown}
            />
            <button onClick={handleSeartch}>Buscar</button>
        </div>
    )
}
