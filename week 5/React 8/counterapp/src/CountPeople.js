import React, { Component } from 'react';

class CountPeople extends Component {

    constructor() {
        super();

        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    updateEntry = () => {
        this.setState((prevState) => {
            return {
                entrycount: prevState.entrycount + 1
            };
        });
    }

    updateExit = () => {
        this.setState((prevState) => {
            return {
                exitcount: prevState.exitcount + 1
            };
        });
    }

    render() {
        return (
            <div style={{ marginTop: "150px" }}>

                <button
                    onClick={this.updateEntry}
                    style={{
                        backgroundColor: "lightgreen",
                        marginLeft: "250px"
                    }}
                >
                    Login
                </button>

                <span>
                    {" "}
                    {this.state.entrycount} People Entered!!!
                </span>

                <button
                    onClick={this.updateExit}
                    style={{
                        backgroundColor: "lightgreen",
                        marginLeft: "250px"
                    }}
                >
                    Exit
                </button>

                <span>
                    {" "}
                    {this.state.exitcount} People Left!!!
                </span>

            </div>
        );
    }
}

export default CountPeople;