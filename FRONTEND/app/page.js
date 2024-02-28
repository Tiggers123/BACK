"use client";
import React, { useState } from "react";
import styles from "./home.module.css";

const Home = () => {
  const [name, setName] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleInputChange = (event) => {
    setName(event.target.value);
  };

  const handleJoinGame = () => {
    if (name.trim() === "") {
      setErrorMessage("Please input your name.");
    } else {
      window.location.href = "/pages/menu";
    }
  };

  return (
    <div className="outer-container">
      <div className="inner-container"></div>
      <div className="content-wrapper">
        <h1 className={styles.desc}>UPBEAT</h1>
        <input
          type="text"
          placeholder="Please input your name..."
          className={styles.nameinput}
          value={name}
          onChange={handleInputChange}
        />
        {errorMessage && (
          <p
            style={{
              color: "red",
              fontFamily: "Loveded",
              textAlign: "center",
              fontSize: "25px",
              marginLeft: "72px",
              marginTop: "20px",
              marginBottom: "-15px",
            }}
          >
            {errorMessage}
          </p>
        )}
        <button className="button" onClick={handleJoinGame}>
          <span className="button-text">Join Game</span>
          <div className="fill-container"></div>
        </button>
      </div>
    </div>
  );
};

export default Home;
