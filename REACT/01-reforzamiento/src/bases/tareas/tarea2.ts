import { heroes, Owner } from "../data/heroes.data";

export const getHeroByOwner = ( owner: Owner ) => {

    const heroByOwner = heroes.filter(hero => hero.owner === owner);
    return heroByOwner
}

console.log(getHeroByOwner(Owner.DC));