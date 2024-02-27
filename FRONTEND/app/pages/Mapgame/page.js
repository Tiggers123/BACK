import React from "react";
import styles from "./mapgame.module.css";
import HexGrid from "../components/HexGrid";
import { useNavigate } from "react-router-dom";
const Mapgame = () => {
  return (
    <div className={styles.bg}>
      <div className="rpgui-content">
        <div
          className="rpgui-container framed"
          style={{
            width: "850px",
            height: "650px",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "40px",
            marginLeft: "50px",
          }}
        >
          <HexGrid row={16} column={20} />
        </div>
        <div
          className="rpgui-container framed-golden-2"
          style={{
            width: "550px",
            height: "675px",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between", // Align items with space between
            alignItems: "center",
            marginTop: "25px",
            marginLeft: "950px",
            position: "relative",
          }}
        >
          <div
            className="rpgui-container"
            style={{
              marginTop: "35px", // Adjust margin top for spacing
            }}
          >
            <span
              style={{
                fontFamily: "hello",
                fontSize: "32px",
                textAlign: "center",
              }}
            >
              OPPONENT'TURN
            </span>
            <hr className="golden" style={{ marginTop: "20px" }}></hr>
          </div>
          <div className={styles.box}>
            <div
              class="rpgui-icon sword"
              style={{
                marginRight: "-15px",
                marginBottom: "-15px",
                marginLeft: "-30px",
              }}
            ></div>{" "}
            DEPOSIT:100000
            <br />
            <br />
            <div
              class="rpgui-icon shield"
              style={{
                marginRight: "-15px",
                marginBottom: "-15px",
                marginLeft: "-30px",
              }}
            ></div>{" "}
            BUDGET:100000
            <br />
            <br />
            <div
              class="rpgui-icon potion-red"
              style={{
                marginRight: "-15px",
                marginBottom: "-15px",
                marginLeft: "-30px",
              }}
            ></div>{" "}
            COLUMN:20
            <br />
            <br />
            <div
              class="rpgui-icon potion-blue"
              style={{
                marginRight: "-15px",
                marginBottom: "-15px",
                marginLeft: "-30px",
              }}
            ></div>{" "}
            ROW:20
          </div>
          <button
            class="rpgui-button golden"
            type="button"
            style={{
              marginBottom: "20px", // Adjust margin bottom for spacing
            }}
          >
            <p style={{ fontFamily: "hello", marginTop: "12px" }}>
              CONSTRUCTION PLAN
            </p>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Mapgame;
