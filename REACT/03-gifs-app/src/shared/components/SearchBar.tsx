interface Props {
    buttonName: string;
    placeHolder?: string
}

export const SearchBar = ({ buttonName, placeHolder='Buscar' }: Props) => {
    return(
        <div className="search-container">
            <input type="text" placeholder={ placeHolder } />
            <button>{buttonName}</button>
        </div>
    )
}