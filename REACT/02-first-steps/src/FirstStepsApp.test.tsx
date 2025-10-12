import { render, screen } from "@testing-library/react";
import { afterEach, describe, expect, test, vi } from 'vitest';
import { FirstStepsApp } from "./FirstStepsApp";

const mockItemCounter = vi.fn( (_props: unknown) => {
    return <div data-testid="ItemCounter" />;
});



vi.mock('./shopping-cart/ItemCounter', ()=>({
    ItemCounter: (props: unknown) => mockItemCounter(props), 
}));


describe('FirstStepUp', ()=>{

    afterEach(() => {
        vi.clearAllMocks();
    })

    
    test('should match snapshot', ()=>{
        const { container } = render (<FirstStepsApp />);

        expect(container).toMatchSnapshot();
    });

    test('should render that correct number of ItemCounter components', ()=>{
        render(<FirstStepsApp />);

        const itemCounters = screen.getAllByTestId('ItemCounter');
        expect (itemCounters.length).toBe(3);
    });

    test('should render Itemcounter with correct props', () =>{
        render(<FirstStepsApp />);

        expect(mockItemCounter).toHaveBeenCalledTimes(3);
        expect(mockItemCounter).toHaveBeenCalledWith({
            name: 'Nintendo Switch 2',
            quantity: 1,
        });
        expect(mockItemCounter).toHaveBeenCalledWith({
            name: 'Pro Controller',
            quantity: 2,
        })
        expect(mockItemCounter).toHaveBeenCalledWith({
            name: 'Super Smash Bros',
            quantity: 5,
        })
    })

})