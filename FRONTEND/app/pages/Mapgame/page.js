import Link from "next/link";
import React from "react";
import styles from "./mapgame.module.css";
import HexGrid from "../components/HexGrid";
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
              marginTop: "20px", // Adjust margin top for spacing
            }}
          >
            <span
              style={{
                fontFamily: "hello",
                fontSize: "32px",
                textAlign: "center",
                marginLeft: "15px",
              }}
            >
              OPPONENT'TURN
            </span>
            <hr className="golden" style={{ marginTop: "10px" }}></hr>
            <div className={styles.box}>
              {" "}
              <p
                style={{
                  fontSize: "20px",
                  fontFamily: "hello",
                  textAlign: "center",
                }}
              >
                <p
                  style={{
                    textAlign: "center",
                    marginBottom: "-20px",
                    fontSize: "24px",
                    fontFamily: "hello",
                    marginTop: "12px",
                  }}
                >
                  PLAYER 1
                </p>
                <br />
                <br />
                DEPOSIT:1000000
                <br />
                <br />
                BUDGET:10000
                <br />
                <br />
                COLUMN:20 ROW:20
              </p>
              <div className={styles.boxs}>
                {" "}
                <p
                  style={{
                    fontSize: "20px",
                    fontFamily: "hello",
                    textAlign: "center",
                  }}
                >
                  <p
                    style={{
                      textAlign: "center",
                      marginBottom: "-20px",
                      fontSize: "24px",
                      fontFamily: "hello",
                      marginTop: "12px",                
                    }}
                  >
                    PLAYER 2
                  </p>
                  <br />
                  <br />
                  DEPOSIT:1000000
                  <br />
                  <br />
                  BUDGET:10000
                  <br />
                  <br />
                  COLUMN:20 ROW:20
                </p>
              </div>
            </div>
          </div>
          <Link href="/pages/Game">
            <button
              class="rpgui-button golden"
              type="button"
              style={{
                marginTop: "550px",
                marginInlineStart: "20px",
              }}
            >
              <p style={{ fontFamily: "hello", marginTop: "12px" }}>
                CONSTRUCTION PLAN
              </p>
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Mapgame;
