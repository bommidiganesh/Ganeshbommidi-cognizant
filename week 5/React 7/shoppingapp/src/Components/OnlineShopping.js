import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

    constructor() {
        super();

        this.items = [
            { itemName: "Laptop", price: 55000 },
            { itemName: "Mobile", price: 25000 },
            { itemName: "Headphones", price: 3000 },
            { itemName: "Keyboard", price: 1200 },
            { itemName: "Mouse", price: 800 }
        ];
    }

    render() {
        return (
            <div>

                <h1>items ordered</h1>

                <table>

                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>

                    <tbody>
                        {this.items.map((item, index) => (
                            <Cart
                                key={index}
                                itemName={item.itemName}
                                price={item.price}
                            />
                        ))}
                    </tbody>

                </table>

            </div>
        );
    }
}

export default OnlineShopping;