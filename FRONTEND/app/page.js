import Link from "next/link";
import React from "react";
import styles from "./home.module.css";

const Home = () => {
  return (
    <div className="outer-container">
      <div className="inner-container"></div>
      <div className="content-wrapper">
        <h1 className={styles.desc}>UPBEAT</h1>
        <input
          type="text"
          placeholder="Please input your name..."
          className={styles.nameinput}
        />
        <button className="button">
          <Link href="/pages/menu">
            <span className="button-text">Join Game</span>
            <div className="fill-container"></div>
          </Link>
        </button>
      </div>
    </div>
  );
};

export default Home;
