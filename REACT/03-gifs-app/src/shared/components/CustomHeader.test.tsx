import { render, screen } from "@testing-library/react";
import { describe, expect, test } from "vitest";
import { CustomHeader } from "./CustomHeader";

describe('CustomHEader', () => {
    const title = 'Test title';

    test('should render the tittle correctly', () => {
        render(<CustomHeader title={title}/>)

        expect (screen.getByText(title)).toBeDefined();
    });

    test('should render the description when provided', () => {
        const description = 'Test description';
        render(<CustomHeader  title={title} description={description}/>)

        expect (screen.getByText(description)).toBeDefined();
        expect(screen.getByRole('paragraph')).toBeDefined();
        expect(screen.getByRole('paragraph').innerHTML).toBe(description);
    });

    test('should not render the description when not provided', () => {
        const { container } = render(<CustomHeader title={title} />);

        const divElement = container.querySelector('.content-center');
        const h1 = divElement?.querySelector('h1');
        const p = divElement?.querySelector('p');
        expect(h1?.innerHTML).toBe(title)
        expect(p).toBeNull();

    });
})