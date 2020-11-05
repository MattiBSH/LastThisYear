import React, { useState, useEffect } from 'react';
const JokeHolder = () => {
    const [joke, setJoke] = useState("");
    const [joke2, setJoke2] = useState("");

    async function fetchJokes() {
        const response = await fetch('http://localhost:8080/jokeFetcher/api/jokes');
        const joke1 = await response.json()
        return setJoke(joke1.dadDTO.joke), setJoke2(joke1.chuck.value);
    }

    useEffect(() => {
        fetchJokes();
    }, []);

    return (
        <h3>
            {joke}
            <br />
            <br />
            {joke2}
        </h3>
    );
}

export default JokeHolder;