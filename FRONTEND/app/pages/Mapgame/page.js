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
        <div
          className="rpgui-container framed-golden-2"
          style={{
            width: "500px",
            height: "675px",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "30px",
            marginLeft: "1000px",
          }}
        >
          <div
            className="rpgui-container" // Keep OPPONENT TURN and <hr> outside of the white box
            style={{
              marginBottom: "500px",
            }}
          >
            <span
              style={{
                fontFamily: "hello",
                fontSize: "30px",
                textAlign: "center",
              }}
            >
              OPPONENT TURN
            </span>
            <hr className="golden" style={{ marginTop: "20px" }}></hr>
          </div>
          <div className={styles.box}>
            <div
              class="rpgui-icon sword"
              style={{ marginRight: "-10px", marginBottom: "-15px" }}
            ></div>{" "}
            {/* Add margin-right */}
            DEPOSIT:100000
            <br />
            <br />
            <div
              class="rpgui-icon shield"
              style={{ marginRight: "-10px", marginBottom: "-15px" }} // Add negative margin-top
            ></div>{" "}
            {/* Add margin-right */}
            BUDGET:100000
            <br />
            <br />
            <div
              class="rpgui-icon potion-red"
              style={{ marginRight: "-10px", marginBottom: "-15px" }} // Add negative margin-top
            ></div>{" "}
            {/* Add margin-right */}
            COLUMN:20
            <br />
            <br />
            <div
              class="rpgui-icon potion-blue"
              style={{ marginRight: "-10px", marginBottom: "-15px" }} // Add negative margin-top
            ></div>{" "}
            {/* Add margin-right */}
            ROW:20
          </div>
        </div>
      </div>
    </div>
  );
};

export default Mapgame;
