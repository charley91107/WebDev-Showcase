import type { FC } from "react";

interface Props {
    searches: string[];
}

export const PreviousSearches: FC<Props> = ({ searches }: Props) => {
    return(
        <div className="previous-searches">
            <h2>Búsquedas previas</h2>
            <ul className="previous-searches-list">
                {
                    searches.map(term => (
                        <li key={term}>{term}</li>
                    ))
                }
            </ul>
        </div>
    )
}