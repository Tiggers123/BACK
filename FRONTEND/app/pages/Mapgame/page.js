"use client";
import React from "react";
import styles from "./mapgame.module.css";
import HexGrid from "../components/HexGrid";

const Mapgame = () => {
  return (
    <div className={styles.bg}>
      <div class="rpgui-content">
        <div
          class="rpgui-container framed"
          style={{
            width: "900px",
            height: "650px",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "40px",
            marginLeft: "50px",
          }}
        >
          <HexGrid row={15} column={15} />
        </div>
      </div>
    </div>
  );
};

export default Mapgame;
