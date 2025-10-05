import type { CSSProperties } from 'react';

export function MyAwesomeApp() {
    const lastName = "Muñoz";
    const firstName = " Carlos";

    const favoriteGames = [
        "The Legend of Zelda",
        "Super Mario",
        "Pokemon"
    ];
    const isActive = false;

    const address = {
        zipCode: 'ABC-123',
        country : 'Canada'
    };

    const myStyles: CSSProperties = {
        backgroundColor: '#fafafa',
        borderRadius: isActive ? 10 : 0,
        padding: 10
    }

    return(
        <>
            <h1 data-testid ="first-name-title">{firstName}</h1>
            <h3>{ lastName }</h3>

            <p>{ favoriteGames.join(", ") }</p>
            <p>{2 + 2}</p>

            <h1>{ isActive ? "Active" : "Inactive"}</h1>
            <p style={myStyles}>{JSON.stringify(address)}</p>
        </>
    )
}