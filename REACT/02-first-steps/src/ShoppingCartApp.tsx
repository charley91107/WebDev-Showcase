import { ItemCounter } from "./shopping-cart/ItemCounter";

interface ItemInCart {
    productName: string;
    quantity: number;
}

const itemsInCart: ItemInCart[] = [
    { productName: 'Nintendo Switch 2', quantity: 1 },
    { productName: 'Pro Controller', quantity: 2 },
    { productName: 'Super Smash Bros', quantity: 5 },
];


export function ShoppingCartApp() {
    return (
        <>
            <h1>Carrito de compras</h1>

            {/* <ItemCounter name="Nintendo Switch 2" quantity={1} />
            <ItemCounter name = "Pro Controller" quantity={2}/>
            <ItemCounter name = "Super Smash Bros" quantity={3}/>
            <ItemCounter name = "Super Mario" quantity={3}/>  */}
            {
                itemsInCart.map( ({ productName, quantity }) => (
                    <ItemCounter key={productName} name={productName} quantity={quantity}  />
                ))
            }
        </>
    )
}