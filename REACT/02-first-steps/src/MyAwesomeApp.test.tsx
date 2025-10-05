import { render, screen } from '@testing-library/react';
import { describe, expect, test } from "vitest";

import { MyAwesomeApp } from './MyAwesomeApp';


describe('MyAwesomeApp', () => {
    test('should render firstName and lastName', () => {
        const { container } = render (<MyAwesomeApp />);
        //screen.debug();

        const h1 = container.querySelector('h1');
        const h3 = container.querySelector('h3');
        
        expect(h1?.innerHTML).toContain('Carlos');
        expect(h3?.innerHTML).toContain('Muñoz');
    });

    test('should render firstName and lastName - screen', () => {
        render (<MyAwesomeApp />);
        screen.debug();

        const h1 = screen.getByTestId('first-name-title');
        expect(h1.innerHTML).toContain('Carlos');
    });

    test('should match snapshot', () => {
        const { container } = render(<MyAwesomeApp />)
        expect(container).toMatchSnapshot();
    })

    test('should match snapshot2', () => {
        render(<MyAwesomeApp />)
        expect( screen.getByTestId('div-app') ).toMatchSnapshot();
    }) 
})