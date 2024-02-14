import Link from "next/link";
import styles from "./home.module.css";
import React from "react";
import { url } from "inspector";

const Home = () => {
  return (
    <div className="outer-container">
      <div className="inner-container"></div>
      <div className="content-wrapper">
        <h1 className="desc">UPBEAT</h1>
        <input
          type="text"
          placeholder="Please input your name..."
          className="name-input"
        />
        <button class="button">
          <span class="button-text">Join game</span>
          <div class="fill-container"></div>
        </button>
      </div>
    </div>
  );
};

export default Home;
